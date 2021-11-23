import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {


    Map<String,String> mapOfCodonsAndAminoAcid = new HashMap<String,String>();
    ProteinTranslator(){
        mapOfCodonsAndAminoAcid.put("AUG","Methionine");
        mapOfCodonsAndAminoAcid.put("UUU","Phenylalanine");
        mapOfCodonsAndAminoAcid.put("UUC","Phenylalanine");
        mapOfCodonsAndAminoAcid.put("UUA","Leucine");
        mapOfCodonsAndAminoAcid.put("UUG","Leucine");
        mapOfCodonsAndAminoAcid.put("UCU","Serine");
        mapOfCodonsAndAminoAcid.put("UCC","Serine");
        mapOfCodonsAndAminoAcid.put("UCA","Serine");
        mapOfCodonsAndAminoAcid.put("UCG","Serine");
        mapOfCodonsAndAminoAcid.put("UAU","Tyrosine");
        mapOfCodonsAndAminoAcid.put("UAC","Tyrosine");
        mapOfCodonsAndAminoAcid.put("UGU","Cysteine");
        mapOfCodonsAndAminoAcid.put("UGC","Cysteine");
        mapOfCodonsAndAminoAcid.put("UGG","Tryptophan");
        mapOfCodonsAndAminoAcid.put("UAA","STOP");
        mapOfCodonsAndAminoAcid.put("UAG","STOP");
        mapOfCodonsAndAminoAcid.put("UGA","STOP");
    }

    List<String> translate(String rnaSequence) {
        if(rnaSequence.length()<3){
            return List.of();
        }


        String[] codonsArray = new String[rnaSequence.length()/3];
        for(int i=0 ,j=0; i<rnaSequence.length();i=i+3,j++){
            codonsArray[j] = rnaSequence.substring(i, i + 3);
        }
        List<String> listOfAminoAcids = new ArrayList<>();
        for(String codon : codonsArray){
            if(mapOfCodonsAndAminoAcid.get(codon).equals("STOP")){
                break;
            }
            listOfAminoAcids.add(mapOfCodonsAndAminoAcid.get(codon));

        }
        return listOfAminoAcids;

    }
}
