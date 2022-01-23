import java.io.File;
import java.io.FilenameFilter;
public class Filter implements FilenameFilter{
    final String a;
    public Filter(String b){a=b;}
    @Override
    public boolean accept(File d, String n) {
        return n.endsWith(a);
    }
}