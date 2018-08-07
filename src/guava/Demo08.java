package guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.Set;

/**
 * 双键map: Table
 * 1.所有都数据：cellset
 * 所有的学生 rowkeyset();
 * 所有课程：columKeySet()
 * 所有成绩: values()
 * 学生对应成绩：rowmap()+get()
 * row(学生)
 */
public class Demo08 {
    public static void main(String[] args) {
        HashBasedTable<String, String, Integer> tables = HashBasedTable.create();
        tables.put("b", "javase", 10);
        tables.put("a", "javase", 100);
        tables.put("a", "C#", 123);
        tables.put("b", "C#", 100);

        Set<Table.Cell<String, String, Integer>> cells = tables.cellSet();
        for (Table.Cell<String, String, Integer> cell : cells) {
            System.out.println(cell.getRowKey() + "-->" + cell.getColumnKey() + "-->" + cell.getValue());
        }

        System.out.println("----------按学生查成绩------------");

        Set<String> cours = tables.columnKeySet();
        for (String cour : cours) {
            System.out.print("\t" + cour);
        }
        System.out.println();
        Set<String> stu = tables.rowKeySet();
        for (String s : stu) {
            System.out.print(s + "\t");
            Map<String, Integer> sources = tables.row(s);
            for (String s1 : cours) {
                System.out.print(sources.get(s1) + "\t");
            }
            System.out.println();
        }

        System.out.println("-------按课程查课程------");

        Set<String> stus = tables.rowKeySet();
        for (String s : stus) {
            System.out.print("\t" + s);
        }
        System.out.println();
        Set<String> courses = tables.columnKeySet();
        for (String s : courses) {
            System.out.print(s+"\t");
            Map<String, Integer> column = tables.column(s);
            for (String stus1 : stus) {
                System.out.print(column.get(stus1)+"\t");
            }
            System.out.println();
        }

        System.out.println("行列转化--------------");
        Table<String, String, Integer> transpose = Tables.transpose(tables);

        Set<Table.Cell<String, String, Integer>> cells2 = transpose.cellSet();
        for (Table.Cell<String, String, Integer> cell : cells2 ) {
            System.out.println(cell.getRowKey() + "-->" + cell.getColumnKey() + "-->" + cell.getValue());
        }

    }
}
