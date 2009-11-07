package org.broadinstitute.sting.playground.gatk.walkers.Recalibration;

import org.broadinstitute.sting.utils.BaseUtils;
import org.broadinstitute.sting.utils.QualityUtils;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: rpoplin
 * Date: Nov 3, 2009
 */

public class RecalDatum {

    long numObservations; // number of bases seen in total
    long numMismatches; // number of bases seen that didn't match the reference


    //---------------------------------------------------------------------------------------------------------------
    //
    // constructors
    //
    //---------------------------------------------------------------------------------------------------------------
    public RecalDatum() {
        numObservations = 0L;
        numMismatches = 0L;
    }

    public RecalDatum( long _numObservations, long _numMismatches ) {
        numObservations = _numObservations;
        numMismatches = _numMismatches;
    }

    public RecalDatum( RecalDatum copy ) {
        this.numObservations = copy.numObservations;
        this.numMismatches = copy.numMismatches;
    }

    //---------------------------------------------------------------------------------------------------------------
    //
    // increment methods
    //
    //---------------------------------------------------------------------------------------------------------------


    public RecalDatum increment( long incObservations, long incMismatches ) {
        numObservations += incObservations;
        numMismatches += incMismatches;
        return this;
    }

    public RecalDatum increment( RecalDatum other ) {
        return increment( other.numObservations, other.numMismatches );
    }

    public RecalDatum increment( List<RecalDatum> data ) {
        for ( RecalDatum other : data ) {
            this.increment( other );
        }
        return this;
    }

    public RecalDatum increment( char curBase, char ref ) {
        return increment( 1, BaseUtils.simpleBaseToBaseIndex(curBase) == BaseUtils.simpleBaseToBaseIndex(ref) ? 0 : 1 ); // inc takes num observations, then num mismatches
    }

    //---------------------------------------------------------------------------------------------------------------
    //
    // methods to derive empirical quality score
    //
    //---------------------------------------------------------------------------------------------------------------

    public double empiricalQualDouble( int smoothing ) {
        double doubleMismatches = (double) ( numMismatches + smoothing );
        double doubleObservations = (double) ( numObservations + smoothing );
        double empiricalQual = -10 * Math.log10(doubleMismatches / doubleObservations);
        if (empiricalQual > QualityUtils.MAX_REASONABLE_Q_SCORE) empiricalQual = QualityUtils.MAX_REASONABLE_Q_SCORE;
        return empiricalQual;
    }
    public double empiricalQualDouble() { return empiricalQualDouble( 0 ); } // 'default' behavior is to use smoothing value of zero


    public byte empiricalQualByte( int smoothing ) {
        double doubleMismatches = (double) ( numMismatches + smoothing );
        double doubleObservations = (double) ( numObservations + smoothing );
        return QualityUtils.probToQual( 1.0 - doubleMismatches / doubleObservations );
    }
    public byte empiricalQualByte() { return empiricalQualByte( 0 ); } // 'default' behavior is to use smoothing value of zero

    //---------------------------------------------------------------------------------------------------------------
    //
    // misc. methods
    //
    //---------------------------------------------------------------------------------------------------------------

    public String outputToCSV( ) {
        return String.format( "%d,%d,%d", numObservations, numMismatches, (int)empiricalQualByte() );
    }
    public String outputToCSV( int smoothing ) {
        return String.format( "%d,%d,%d", numObservations, numMismatches, (int)empiricalQualByte( smoothing ) );
    }

    public Long getNumObservations() {
        return numObservations;
    }
    
    public String toString() {
    	return String.format( "RecalDatum: %d,%d,%d", numObservations, numMismatches, (int)empiricalQualByte() );
    }
}
