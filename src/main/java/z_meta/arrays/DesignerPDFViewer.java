package z_meta.arrays;
import java.util.List;

/*
When a contiguous block of text is selected in a PDF viewer, the selection is highlighted with a blue rectangle. In this PDF viewer, each word is highlighted independently. For example:
PDF-highighting.png
There is a list of  character heights aligned by index to their letters. For example, 'a' is at index  and 'z' is at index . There will also be a string. Using the letter heights given, determine the area of the rectangle highlight in  assuming all letters are  wide.
Example

The heights are  and . The tallest letter is  high and there are  letters. The hightlighted area will be  so the answer is .
 */
public class DesignerPDFViewer {

    public static int designerPdfViewer(List<Integer> h, String word) {

        char[] wordArray = word.toCharArray();
        int maxHeight = 0;

        for(char ch:wordArray) {
            int height = h.get(ch-97);
            maxHeight = Math.max(maxHeight,height);
        }
        return word.length() * maxHeight;
    }

    public static void main(String s[]) {

    }

}
