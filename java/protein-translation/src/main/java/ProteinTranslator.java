import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ProteinTranslator {


    private Map<String, String> mapOfCodonsAndAminoAcid = new HashMap<>();

    ProteinTranslator() {
        mapOfCodonsAndAminoAcid.put("AUG", "Methionine");
        mapOfCodonsAndAminoAcid.put("UUU", "Phenylalanine");
        mapOfCodonsAndAminoAcid.put("UUC", "Phenylalanine");
        mapOfCodonsAndAminoAcid.put("UUA", "Leucine");
        mapOfCodonsAndAminoAcid.put("UUG", "Leucine");
        mapOfCodonsAndAminoAcid.put("UCU", "Serine");
        mapOfCodonsAndAminoAcid.put("UCC", "Serine");
        mapOfCodonsAndAminoAcid.put("UCA", "Serine");
        mapOfCodonsAndAminoAcid.put("UCG", "Serine");
        mapOfCodonsAndAminoAcid.put("UAU", "Tyrosine");
        mapOfCodonsAndAminoAcid.put("UAC", "Tyrosine");
        mapOfCodonsAndAminoAcid.put("UGU", "Cysteine");
        mapOfCodonsAndAminoAcid.put("UGC", "Cysteine");
        mapOfCodonsAndAminoAcid.put("UGG", "Tryptophan");
        mapOfCodonsAndAminoAcid.put("UAA", "STOP");
        mapOfCodonsAndAminoAcid.put("UAG", "STOP");
        mapOfCodonsAndAminoAcid.put("UGA", "STOP");
    }

    List<String> translate(String rnaSequence) {
        List<String> codonsArray = splitString(rnaSequence, 3);
        return codonsArray.stream()
            .takeWhile(codon -> !mapOfCodonsAndAminoAcid.get(codon).equals("STOP"))
            .map(mapOfCodonsAndAminoAcid::get)
            .collect(Collectors.toList());
    }

    //ABBABCABD ->[ABB,ABC,ABD]
    private List<String> splitString(String rnaSequence, int length) {
        List<String> codonsArray = new ArrayList<>();
        for (int i = 0, j = 0; i < rnaSequence.length(); i = i + length, j++) {
            int endIndex = i + length;
            codonsArray.add(rnaSequence.substring(i, Math.min(endIndex, rnaSequence.length())));
        }
        return codonsArray;
    }
}
