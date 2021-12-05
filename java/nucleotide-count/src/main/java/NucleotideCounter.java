import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {

    private String dna;

    NucleotideCounter(String dna) {
        if (dna.matches(".*[^ACGT].*")) {
            throw new IllegalArgumentException();
        }
        this.dna = dna;
    }

    Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> nucleotideCount = new HashMap<>();
        nucleotideCount.put('A', 0);
        nucleotideCount.put('C', 0);
        nucleotideCount.put('G', 0);
        nucleotideCount.put('T', 0);
        for (Character nucleotide : dna.toCharArray()) {
            nucleotideCount.compute(nucleotide, (k, v) -> v + 1);
        }
        return nucleotideCount;
    }
}
