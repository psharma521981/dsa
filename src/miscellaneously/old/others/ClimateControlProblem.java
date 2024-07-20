package src.miscellaneously.old.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/*
Given a list of farms with attributes “name”, “crop”, and “size”, return a list of the top two farms by size for each crop.

 
Example input:
"adams", "corn", 100
"adair", "soybeans", 50
"benton", "soybeans", 90
"boone", "corn", 75
"carroll", "wheat", 200
"creation", "corn", 90
"dansplot" , "soybeans", 55
"edgars", "soybeans", 95
"everlast", "corn", 70
"greenacres", "wheat", 205

output:
"corn" -> ("adams", 100), ("creation", 90)
"soybeans" -> ("edgars", 95), ("benton", 90) 
"wheat" -> ("greenacres", 205), ("carroll", 200)
 */
public class ClimateControlProblem {

    public static void main(String[] args) {
        List<Farms> farmList = new ArrayList<>();

        farmList.add(new Farms("adams", "corn", 100));
        farmList.add(new Farms("adair", "soybeans", 50));
        farmList.add(new Farms("benton", "soybeans", 90));
        farmList.add(new Farms("boone", "corn", 75));
        farmList.add(new Farms("carroll", "wheat", 200));
        farmList.add(new Farms("creation", "corn", 90));
        farmList.add(new Farms("dansplot", "soybeans", 55));
        farmList.add(new Farms("edgars", "soybeans", 95));
        farmList.add(new Farms("everlast", "corn", 70));
        farmList.add(new Farms("greenacres", "wheat", 205));

        System.out.println(filterFarmData(farmList));

    }

    public static Map<String, TreeSet<Farms>> filterFarmData(List<Farms> farmList) {
        if (farmList == null || farmList.size() == 0)
            return null;

        Map<String, TreeSet<Farms>> output = new HashMap<>();

        farmList.forEach(f -> {

            if (!output.containsKey(f.crop)) {
                output.put(f.crop, new TreeSet<Farms>(new FarmDataComparator()));
            }
            TreeSet<Farms> farmData = output.get(f.crop);
            farmData.add(new Farms(f.name, f.size));
            if (farmData.size() > 2)
                farmData.remove(farmData.last());
            output.put(f.crop, farmData);

        });

        return output;

    }

}

class FarmDataComparator implements Comparator<Farms> {

    @Override
    public int compare(Farms o1, Farms o2) {
        return o2.size - o1.size;
    }
}
class Farms {

    public String name;
    public String crop;
    public int size;

    Farms(String name, String crop, int size) {
        this.crop = crop;
        this.name = name;
        this.size = size;
    }

    Farms(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String toString() {
        return this.name + "->" + this.size;
    }

}
