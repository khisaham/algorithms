public class CropSentence {
    public static void main(String[] args)
    {
        String word = "come to town now";
        int k = 10;
        char [] wordArray = word.toCharArray();
        char [] newWordArray = {};

        for(int j =0; j<k; j++){
            if(wordArray[j] > 0)
            System.out.print(wordArray[j]);
        }
//        System.out.println(wordArray.length);
    }
}
