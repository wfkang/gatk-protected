/*
*  By downloading the PROGRAM you agree to the following terms of use:
*  
*  BROAD INSTITUTE - SOFTWARE LICENSE AGREEMENT - FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
*  
*  This Agreement is made between the Broad Institute, Inc. with a principal address at 7 Cambridge Center, Cambridge, MA 02142 (BROAD) and the LICENSEE and is effective at the date the downloading is completed (EFFECTIVE DATE).
*  
*  WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
*  WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
*  NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
*  
*  1. DEFINITIONS
*  1.1 PROGRAM shall mean copyright in the object code and source code known as GATK2 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute/GATK on the EFFECTIVE DATE.
*  
*  2. LICENSE
*  2.1   Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. 
*  The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only.  For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
*  2.2  No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD.  LICENSEE shall ensure that all of its users agree to the terms of this Agreement.  LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
*  2.3  License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.  
*  
*  3. OWNERSHIP OF INTELLECTUAL PROPERTY 
*  LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies.  LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
*  Copyright 2012 Broad Institute, Inc.
*  Notice of attribution:  The GATK2 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
*  LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
*  
*  4. INDEMNIFICATION
*  LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
*  
*  5. NO REPRESENTATIONS OR WARRANTIES
*  THE PROGRAM IS DELIVERED AS IS.  BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
*  IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
*  
*  6. ASSIGNMENT
*  This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
*  
*  7. MISCELLANEOUS
*  7.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
*  7.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
*  7.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
*  7.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested.  All notices under this Agreement shall be deemed effective upon receipt. 
*  7.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter. 
*  7.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
*  7.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.sting.gatk.walkers.haplotypecaller.readthreading;

import org.apache.log4j.Logger;
import org.broadinstitute.sting.gatk.walkers.haplotypecaller.KMerCounter;
import org.broadinstitute.sting.gatk.walkers.haplotypecaller.Kmer;
import org.broadinstitute.sting.gatk.walkers.haplotypecaller.graphs.*;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.collections.PrimitivePair;
import org.broadinstitute.sting.utils.sam.GATKSAMRecord;
import org.jgrapht.EdgeFactory;

import java.io.File;
import java.util.*;

public class ReadThreadingGraph extends BaseGraph<MultiDeBruijnVertex, MultiSampleEdge> {
    /**
     * Edge factory that creates non-reference multiplicity 1 edges
     */
    private static class MyEdgeFactory implements EdgeFactory<MultiDeBruijnVertex, MultiSampleEdge> {
        @Override
        public MultiSampleEdge createEdge(MultiDeBruijnVertex sourceVertex, MultiDeBruijnVertex targetVertex) {
            return new MultiSampleEdge(false, 1);
        }
    }

    private final static Logger logger = Logger.getLogger(ReadThreadingGraph.class);

    private final static String ANONYMOUS_SAMPLE = "XXX_UNNAMED_XXX";
    private final static boolean WRITE_GRAPH = false;
    private final static boolean DEBUG_NON_UNIQUE_CALC = false;

    /** for debugging info printing */
    private static int counter = 0;

    /** we require at least this many bases to be uniquely matching to merge a dangling tail */
    private final static int MIN_MATCH_LENGTH_TO_RECOVER_DANGLING_TAIL = 5;

    /**
     * Sequences added for read threading before we've actually built the graph
     */
    private final Map<String, List<SequenceForKmers>> pending = new LinkedHashMap<String, List<SequenceForKmers>>();

    /**
     * A set of non-unique kmers that cannot be used as merge points in the graph
     */
    private Set<Kmer> nonUniqueKmers;

    /**
     * A map from kmers -> their corresponding vertex in the graph
     */
    private Map<Kmer, MultiDeBruijnVertex> uniqueKmers = new LinkedHashMap<Kmer, MultiDeBruijnVertex>();

    /**
     *
     */
    final int kmerSize;
    final boolean debugGraphTransformations;
    final byte minBaseQualityToUseInAssembly;

    protected boolean increaseCountsBackwards = true;
    protected boolean increaseCountsThroughBranches = false; // this may increase the branches without bounds

    // --------------------------------------------------------------------------------
    // state variables, initialized in resetToInitialState()
    // --------------------------------------------------------------------------------
    private Kmer refSource;
    private boolean alreadyBuilt;
    byte[] refSeq;
    MultiDeBruijnVertex[] refKmers;

    public ReadThreadingGraph() {
        this(25, false, (byte)6);
    }

    public ReadThreadingGraph(final int kmerSize) {
        this(kmerSize, false, (byte)6);
    }

    /**
     * Create a new ReadThreadingAssembler using kmerSize for matching
     * @param kmerSize must be >= 1
     */
    protected ReadThreadingGraph(final int kmerSize, final boolean debugGraphTransformations, final byte minBaseQualityToUseInAssembly) {
        super(kmerSize, new MyEdgeFactory());

        if ( kmerSize < 1 ) throw new IllegalArgumentException("bad minkKmerSize " + kmerSize);
        this.kmerSize = kmerSize;
        this.debugGraphTransformations = debugGraphTransformations;
        this.minBaseQualityToUseInAssembly = minBaseQualityToUseInAssembly;

        resetToInitialState();
    }

    /**
     * Reset this assembler to its initial state, so we can create another assembly with a different set of reads
     */
    private void resetToInitialState() {
        pending.clear();
        nonUniqueKmers = null;
        uniqueKmers.clear();
        refSource = null;
        alreadyBuilt = false;
        refSeq = null;
        refKmers = null;
    }

    /**
     * Add the all bases in sequence to the graph
     * @param sequence a non-null sequence
     * @param isRef is this the reference sequence?
     */
    protected void addSequence(final byte[] sequence, final boolean isRef) {
        addSequence("anonymous", sequence, null, isRef);
    }

    /**
     * Add all bases in sequence to this graph
     *
     * @see #addSequence(String, String, byte[], int, int, int[], boolean) for full information
     */
    public void addSequence(final String seqName, final byte[] sequence, final int[] counts, final boolean isRef) {
        addSequence(seqName, ANONYMOUS_SAMPLE, sequence, 0, sequence.length, counts, isRef);
    }

    /**
     * Add bases in sequence to this graph
     *
     * @param seqName a useful seqName for this read, for debugging purposes
     * @param sequence non-null sequence of bases
     * @param counts a vector of counts for each bases, indicating how many times that base was observed in the sequence.
     *               This allows us to support reduced reads in the ReadThreadingAssembler.  Can be null, meaning that
     *               each base is only observed once.  If not null, must have length == sequence.length.
     * @param start the first base offset in sequence that we should use for constructing the graph using this sequence, inclusive
     * @param stop the last base offset in sequence that we should use for constructing the graph using this sequence, exclusive
     * @param isRef is this the reference sequence.
     */
    public void addSequence(final String seqName, final String sampleName, final byte[] sequence, final int start, final int stop, final int[] counts, final boolean isRef) {
        // note that argument testing is taken care of in SequenceForKmers
        if ( alreadyBuilt ) throw new IllegalStateException("Graph already built");

        // get the list of sequences for this sample
        List<SequenceForKmers> sampleSequences = pending.get(sampleName);
        if ( sampleSequences == null ) { // need to create
            sampleSequences = new LinkedList<>();
            pending.put(sampleName, sampleSequences);
        }

        // add the new sequence to the list of sequences for sample
        sampleSequences.add(new SequenceForKmers(seqName, sequence, start, stop, counts, isRef));
    }

    /**
     * Return a count appropriate for a kmer starting at kmerStart in sequence for kmers
     *
     * @param seqForKmers a non-null sequence for kmers object
     * @param kmerStart the position where the kmer starts in sequence
     * @return a count for a kmer from start -> start + kmerSize in seqForKmers
     */
    private int getCountGivenKmerStart(final SequenceForKmers seqForKmers, final int kmerStart) {
        return seqForKmers.getCount(kmerStart + kmerSize - 1);
    }

    /**
     * Thread sequence seqForKmers through the current graph, updating the graph as appropriate
     * @param seqForKmers a non-null sequence
     */
    private void threadSequence(final SequenceForKmers seqForKmers) {
        final Pair<MultiDeBruijnVertex,Integer> startingInfo = findStart(seqForKmers);
        if ( startingInfo == null )
            return;

        final MultiDeBruijnVertex startingVertex = startingInfo.getFirst();
        final int uniqueStartPos = startingInfo.getSecond();

        // increase the counts of all edges incoming into the starting vertex supported by going back in sequence
        if ( increaseCountsBackwards )
            increaseCountsInMatchedKmers(seqForKmers, startingVertex, startingVertex.getSequence(), kmerSize - 2);

        if ( debugGraphTransformations ) startingVertex.addRead(seqForKmers.name);

        // keep track of information about the reference kmers for merging dangling tails
        if ( seqForKmers.isRef ) {
            if ( refSource != null ) throw new IllegalStateException("Found two refSources! prev " + refSource + " new is " + startingVertex);
            refSource = new Kmer(seqForKmers.sequence, seqForKmers.start, kmerSize);
            refSeq = seqForKmers.sequence;
            refKmers = new MultiDeBruijnVertex[refSeq.length];
            for ( int i = 0; i < kmerSize; i++ ) refKmers[i] = null;
        }

        // loop over all of the bases in sequence, extending the graph by one base at each point, as appropriate
        MultiDeBruijnVertex vertex = startingVertex;
        for ( int i = uniqueStartPos + 1; i <= seqForKmers.stop - kmerSize; i++ ) {
            final int count = getCountGivenKmerStart(seqForKmers, i);

            vertex = extendChainByOne(vertex, seqForKmers.sequence, i, count, seqForKmers.isRef);
            if ( debugGraphTransformations ) vertex.addRead(seqForKmers.name);

            // keep track of the reference kmers for merging dangling tails
            if ( seqForKmers.isRef ) refKmers[i + kmerSize - 1] = vertex;
        }
    }

    /**
     * Attempt to attach vertex with out-degree == 0 to the graph by finding a unique matching kmer to the reference
     * @param vertex the vertex to recover
     */
    protected int recoverDanglingChain(final MultiDeBruijnVertex vertex) {
        if ( outDegreeOf(vertex) != 0 ) throw new IllegalStateException("Attempting to recover a dangling tail for " + vertex + " but it has out-degree > 0");

        final byte[] kmer = vertex.getSequence();
        if ( ! nonUniqueKmers.contains(new Kmer(kmer)) ) {
            // don't attempt to fix non-unique kmers!
            final MultiDeBruijnVertex uniqueMergePoint = danglingTailMergePoint(kmer);
            if ( uniqueMergePoint != null ) {
                addEdge(vertex, uniqueMergePoint, new MultiSampleEdge(false, 1));
                return 1;
            }
        }

        return 0;
    }

    /**
     * Find a unique merge point for kmer in the reference sequence
     * @param kmer the full kmer of the dangling tail
     * @return a vertex appropriate to merge kmer into, or null if none could be found
     */
    private MultiDeBruijnVertex danglingTailMergePoint(final byte[] kmer) {
        final PrimitivePair.Int endAndLength = GraphUtils.findLongestUniqueSuffixMatch(refSeq, kmer);
        if ( endAndLength != null && endAndLength.second >= MIN_MATCH_LENGTH_TO_RECOVER_DANGLING_TAIL && endAndLength.first + 1 < refKmers.length) {
            final int len = endAndLength.second;
            final MultiDeBruijnVertex mergePoint = refKmers[endAndLength.first + 1];
//            logger.info("recoverDanglingChain of kmer " + new String(kmer) + " merged to " + mergePoint + " with match size " + len);
            final Set<Kmer> nonUniquesAtLength = determineKmerSizeAndNonUniques(len, len).nonUniques;
            final Kmer matchedKmer = new Kmer(kmer, kmer.length - len, len);
            if ( nonUniquesAtLength.contains(matchedKmer) ) {
//                logger.info("Rejecting merge " + new String(kmer) + " because match kmer " + matchedKmer + " isn't unique across all reads");
                return null;
            } else {
                return mergePoint;
            }
        }

        return null;
    }

    /**
     * Build the read threaded assembly graph if it hasn't already been constructed from the sequences that have
     * been added to the graph.
     */
    public void buildGraphIfNecessary() {
        if ( alreadyBuilt ) return;

        // determine the kmer size we'll uses, and capture the set of nonUniques for that kmer size
        final NonUniqueResult result = determineKmerSizeAndNonUniques(kmerSize, kmerSize);
        nonUniqueKmers = result.nonUniques;

        if ( DEBUG_NON_UNIQUE_CALC ) {
            logger.info("using " + kmerSize + " kmer size for this assembly with the following non-uniques");
        }

        // go through the pending sequences, and add them to the graph
        for ( final List<SequenceForKmers> sequencesForSample : pending.values() ) {
            for ( final SequenceForKmers sequenceForKmers : sequencesForSample ) {
                threadSequence(sequenceForKmers);
                if ( WRITE_GRAPH ) printGraph(new File("threading." + counter++ + "." + sequenceForKmers.name.replace(" ", "_") + ".dot"), 0);
            }

            // flush the single sample edge values from the graph
            for ( final MultiSampleEdge e : edgeSet() ) e.flushSingleSampleMultiplicity();
        }

        // clear
        pending.clear();
        alreadyBuilt = true;
    }

    public void recoverDanglingTails() {
        if ( ! alreadyBuilt )  throw new IllegalStateException("recoverDanglingTails requires the graph be already built");

        int attempted = 0;
        int nRecovered = 0;
        for ( final MultiDeBruijnVertex v : vertexSet() ) {
            if ( outDegreeOf(v) == 0 && ! isRefNodeAndRefSink(v) ) {
                attempted++;
                nRecovered += recoverDanglingChain(v);
            }
        }
        //logger.info("Recovered " + nRecovered + " of " + attempted + " dangling tails");
    }

    /** structure that keeps track of the non-unique kmers for a given kmer size */
    private static class NonUniqueResult {
        final Set<Kmer> nonUniques;
        final int kmerSize;

        private NonUniqueResult(Set<Kmer> nonUniques, int kmerSize) {
            this.nonUniques = nonUniques;
            this.kmerSize = kmerSize;
        }
    }

    /**
     * Compute the smallest kmer size >= minKmerSize and <= maxKmerSize that has no non-unique kmers
     * among all sequences added to the current graph.  Will always return a result for maxKmerSize if
     * all smaller kmers had non-unique kmers.
     *
     * @param minKmerSize the minimum kmer size to consider when constructing the graph
     * @param maxKmerSize the maximum kmer size to consider
     * @return a non-null NonUniqueResult
     */
    protected NonUniqueResult determineKmerSizeAndNonUniques(final int minKmerSize, final int maxKmerSize) {
        final Collection<SequenceForKmers> withNonUniques = getAllPendingSequences();
        final Set<Kmer> nonUniqueKmers = new HashSet<Kmer>();

        // go through the sequences and determine which kmers aren't unique within each read
        int kmerSize = minKmerSize;
        for ( ; kmerSize <= maxKmerSize; kmerSize++) {
            // clear out set of non-unique kmers
            nonUniqueKmers.clear();

            // loop over all sequences that have non-unique kmers in them from the previous iterator
            final Iterator<SequenceForKmers> it = withNonUniques.iterator();
            while ( it.hasNext() ) {
                final SequenceForKmers sequenceForKmers = it.next();

                // determine the non-unique kmers for this sequence
                final Collection<Kmer> nonUniquesFromSeq = determineNonUniqueKmers(sequenceForKmers, kmerSize);
                if ( nonUniquesFromSeq.isEmpty() ) {
                    // remove this sequence from future consideration
                    it.remove();
                } else {
                    // keep track of the non-uniques for this kmerSize, and keep it in the list of sequences that have non-uniques
                    nonUniqueKmers.addAll(nonUniquesFromSeq);
                }
            }

            if ( nonUniqueKmers.isEmpty() )
                // this kmerSize produces no non-unique sequences, so go ahead and use it for our assembly
                break;
        }

        // necessary because the loop breaks with kmerSize = max + 1
        return new NonUniqueResult(nonUniqueKmers, Math.min(kmerSize, maxKmerSize));
    }

    /**
     * Get the collection of all sequences for kmers across all samples in no particular order
     * @return non-null Collection
     */
    private Collection<SequenceForKmers> getAllPendingSequences() {
        final LinkedList<SequenceForKmers> result = new LinkedList<SequenceForKmers>();
        for ( final List<SequenceForKmers> oneSampleWorth : pending.values() ) result.addAll(oneSampleWorth);
        return result;
    }

    /**
     * Get the collection of non-unique kmers from sequence for kmer size kmerSize
     * @param seqForKmers a sequence to get kmers from
     * @param kmerSize the size of the kmers
     * @return a non-null collection of non-unique kmers in sequence
     */
    private Collection<Kmer> determineNonUniqueKmers(final SequenceForKmers seqForKmers, final int kmerSize) {
        // count up occurrences of kmers within each read
        final KMerCounter counter = new KMerCounter(kmerSize);
        for ( int i = 0; i <= seqForKmers.stop - kmerSize; i++ ) {
            final Kmer kmer = new Kmer(seqForKmers.sequence, i, kmerSize);
            counter.addKmer(kmer, 1);
        }

        return counter.getKmersWithCountsAtLeast(2);
    }

    /**
     * Convert this kmer graph to a simple sequence graph.
     *
     * Each kmer suffix shows up as a distinct SeqVertex, attached in the same structure as in the kmer
     * graph.  Nodes that are sources are mapped to SeqVertex nodes that contain all of their sequence
     *
     * @return a newly allocated SequenceGraph
     */
    // TODO -- should override base class method
    public SeqGraph convertToSequenceGraph() {
        buildGraphIfNecessary();

        final SeqGraph seqGraph = new SeqGraph(kmerSize);
        final Map<MultiDeBruijnVertex, SeqVertex> vertexMap = new HashMap<MultiDeBruijnVertex, SeqVertex>();

        // create all of the equivalent seq graph vertices
        for ( final MultiDeBruijnVertex dv : vertexSet() ) {
            final SeqVertex sv = new SeqVertex(dv.getAdditionalSequence(isSource(dv)));
            sv.setAdditionalInfo(dv.additionalInfo());
            vertexMap.put(dv, sv);
            seqGraph.addVertex(sv);
        }

        // walk through the nodes and connect them to their equivalent seq vertices
        for( final MultiSampleEdge e : edgeSet() ) {
            final SeqVertex seqInV = vertexMap.get(getEdgeSource(e));
            final SeqVertex seqOutV = vertexMap.get(getEdgeTarget(e));
            //logger.info("Adding edge " + seqInV + " -> " + seqOutV);
            seqGraph.addEdge(seqInV, seqOutV, new BaseEdge(e.isRef(), e.getMultiplicity()));
        }

        return seqGraph;
    }

    private void increaseCountsInMatchedKmers(final SequenceForKmers seqForKmers,
                                              final MultiDeBruijnVertex vertex,
                                              final byte[] originalKmer,
                                              final int offset) {
        if ( offset == -1 ) return;

        for ( final MultiSampleEdge edge : incomingEdgesOf(vertex) ) {
            final MultiDeBruijnVertex prev = getEdgeSource(edge);
            final byte suffix = prev.getSuffix();
            final byte seqBase = originalKmer[offset];
//            logger.warn(String.format("Increasing counts for %s -> %s via %s at %d with suffix %s vs. %s",
//                    prev, vertex, edge, offset, (char)suffix, (char)seqBase));
            if ( suffix == seqBase && (increaseCountsThroughBranches || inDegreeOf(vertex) == 1) ) {
                edge.incMultiplicity(seqForKmers.getCount(offset));
                increaseCountsInMatchedKmers(seqForKmers, prev, originalKmer, offset-1);
            }
        }
    }

    /**
     * Find vertex and its position in seqForKmers where we should start assembling seqForKmers
     *
     * @param seqForKmers the sequence we want to thread into the graph
     * @return a pair of the starting vertex and its position in seqForKmer
     */
    private Pair<MultiDeBruijnVertex, Integer> findStart(final SequenceForKmers seqForKmers) {
        final int uniqueStartPos = seqForKmers.isRef ? 0 : findUniqueStartPosition(seqForKmers.sequence, seqForKmers.start, seqForKmers.stop);

        if ( uniqueStartPos == -1 )
            return null;

        return getOrCreateKmerVertex(seqForKmers.sequence, uniqueStartPos, true);
    }

    /**
     * Find a starting point in sequence that begins a unique kmer among all kmers in the graph
     * @param sequence the sequence of bases
     * @param start the first base to use in sequence
     * @param stop the last base to use in sequence
     * @return the index into sequence that begins a unique kmer of size kmerSize, or -1 if none could be found
     */
    private int findUniqueStartPosition(final byte[] sequence, final int start, final int stop) {
        for ( int i = start; i < stop - kmerSize; i++ ) {
            final Kmer kmer1 = new Kmer(sequence, i, kmerSize);
            if ( uniqueKmers.containsKey(kmer1) )
                return i;
        }
        return -1;
    }

    /**
     * Get the vertex for the kmer in sequence starting at start
     * @param sequence the sequence
     * @param start the position of the kmer start
     * @param allowRefSource if true, we will allow matches to the kmer that represents the reference starting kmer
     * @return a non-null vertex
     */
    private Pair<MultiDeBruijnVertex, Integer> getOrCreateKmerVertex(final byte[] sequence, final int start, final boolean allowRefSource) {
        final Kmer kmer = new Kmer(sequence, start, kmerSize);
        final MultiDeBruijnVertex vertex = getUniqueKmerVertex(kmer, allowRefSource);
        if ( vertex != null ) {
            return new Pair<>(vertex, start);
        } else {
            return new Pair<>(createVertex(kmer), start);
        }
    }

    /**
     * Get the unique vertex for kmer, or null if not possible.
     *
     * @param allowRefSource if true, we will allow kmer to match the reference source vertex
     * @return a vertex for kmer, or null if it's not unique
     */
    private MultiDeBruijnVertex getUniqueKmerVertex(final Kmer kmer, final boolean allowRefSource) {
        if ( ! allowRefSource && kmer.equals(refSource) ) return null;
        return uniqueKmers.get(kmer);
    }

    /**
     * Create a new vertex for kmer.  Add it to the uniqueKmers map if appropriate.
     *
     * kmer must not have a entry in unique kmers, or an error will be thrown
     *
     * @param kmer the kmer we want to create a vertex for
     * @return the non-null created vertex
     */
    private MultiDeBruijnVertex createVertex(final Kmer kmer) {
        final MultiDeBruijnVertex newVertex = new MultiDeBruijnVertex(kmer.bases());
        final int prevSize = vertexSet().size();
        addVertex(newVertex);

        // make sure we aren't adding duplicates (would be a bug)
        if ( vertexSet().size() != prevSize + 1) throw new IllegalStateException("Adding vertex " + newVertex + " to graph didn't increase the graph size");

        // add the vertex to the unique kmer map, if it is in fact unique
        if ( ! nonUniqueKmers.contains(kmer) && ! uniqueKmers.containsKey(kmer) ) // TODO -- not sure this last test is necessary
            uniqueKmers.put(kmer, newVertex);

        return newVertex;
    }

    /**
     * Workhorse routine of the assembler.  Given a sequence whose last vertex is anchored in the graph, extend
     * the graph one bp according to the bases in sequence.
     *
     * @param prevVertex a non-null vertex where sequence was last anchored in the graph
     * @param sequence the sequence we're threading through the graph
     * @param kmerStart the start of the current kmer in graph we'd like to add
     * @param count the number of observations of this kmer in graph (can be > 1 for reduced reads)
     * @param isRef is this the reference sequence?
     * @return a non-null vertex connecting prevVertex to in the graph based on sequence
     */
    private MultiDeBruijnVertex extendChainByOne(final MultiDeBruijnVertex prevVertex, final byte[] sequence, final int kmerStart, final int count, final boolean isRef) {
        final Set<MultiSampleEdge> outgoingEdges = outgoingEdgesOf(prevVertex);

        final int nextPos = kmerStart + kmerSize - 1;
        for ( final MultiSampleEdge outgoingEdge : outgoingEdges ) {
            final MultiDeBruijnVertex target = getEdgeTarget(outgoingEdge);
            if ( target.getSuffix() == sequence[nextPos] ) {
                // we've got a match in the chain, so simply increase the count of the edge by 1 and continue
                outgoingEdge.incMultiplicity(count);
                return target;
            }
        }

        // none of our outgoing edges had our unique suffix base, so we check for an opportunity to merge back in
        final Kmer kmer = new Kmer(sequence, kmerStart, kmerSize);
        MultiDeBruijnVertex uniqueMergeVertex = getUniqueKmerVertex(kmer, false);

        if ( isRef && uniqueMergeVertex != null )
            throw new IllegalStateException("Found a unique vertex to merge into the reference graph " + prevVertex + " -> " + uniqueMergeVertex);

        // either use our unique merge vertex, or create a new one in the chain
        final MultiDeBruijnVertex nextVertex = uniqueMergeVertex == null ? createVertex(kmer) : uniqueMergeVertex;
        addEdge(prevVertex, nextVertex, new MultiSampleEdge(isRef, count));
        return nextVertex;
    }

    /**
     * Get the longest stretch of high quality bases in read and pass that sequence to the graph
     *
     * @param read a non-null read
     */
    protected void addRead(final GATKSAMRecord read) {
        final byte[] sequence = read.getReadBases();
        final byte[] qualities = read.getBaseQualities();
        final int[] reducedReadCounts = read.getReducedReadCounts();  // will be null if read is not reduced

        int lastGood = -1; // the index of the last good base we've seen
        for( int end = 0; end <= sequence.length; end++ ) {
            if ( end == sequence.length || qualities[end] < minBaseQualityToUseInAssembly ) {
                // the first good base is at lastGood, can be -1 if last base was bad
                final int start = lastGood;
                // the stop base is end - 1 (if we're not at the end of the sequence)
                final int stop = end == sequence.length ? sequence.length : end;
                final int len = stop - start + 1;

                if ( start != -1 && len >= kmerSize ) {
                    // if the sequence is long enough to get some value out of, add it to the graph
                    final String name = read.getReadName() + "_" + start + "_" + end;
                    addSequence(name, read.getReadGroup().getSample(), read.getReadBases(), start, stop, reducedReadCounts, false);
                }

                lastGood = -1; // reset the last good base
            } else if ( lastGood == -1 ) {
                lastGood = end; // we're at a good base, the last good one is us
            }
        }
    }

    /**
     * Get the set of non-unique kmers in this graph.  For debugging purposes
     * @return a non-null set of kmers
     */
    protected Set<Kmer> getNonUniqueKmers() {
        return nonUniqueKmers;
    }

    @Override
    public String toString() {
        return "ReadThreadingAssembler{" +
                "kmerSize=" + kmerSize +
                '}';
    }
}