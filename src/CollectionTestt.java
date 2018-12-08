import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

//示范 用一下方法操作 Collection集合里的 元素
public class CollectionTestt
{
    public static void main(String[] args) {
        //List 记住添加元顺序的 有序集合，元素可以重复
        Collection c = new ArrayList();
        //添加元素
        c.add("孙悟空");
        c.add("6");
        System.out.println("c集合的元素个数为：" + c.size());  // c.size()
        //删除指定元素
        c.remove("6");
        System.out.println("删除一个元素后，c集合里的元素个数为" + c.size());
        //判断是否包含指定字符串  c.contans("");
        System.out.println("c集合是否包含孙悟空" + c.contains("孙悟空"));
        //输出 集合C 中的所有元素
        c.add("轻量级Java EE 企业应用实战");
        System.out.println("c集合的元素:" + c);

        //set 无法记住添加顺序的 无序集合，元素不可重复
        Collection books = new HashSet();
        //先添加一些元素，但随即 排列
        books.add("图解Http");
        books.add("SQL必知必会");
        books.add("轻量级Java EE 企业应用实战");
        //判断c集合是否完全包含 books集合，此处 返回 false
        System.out.println("c集合是否完全包含books集合？" + c.containsAll(books));
        //用c集合减去books集合里的元素
        c.removeAll(books);
        System.out.println("减去books集合后，c集合还剩下的元素,books集合允许有多余的元素: " + c );
        //两个集合 取 交集, retain-保持; 留在心中，记住; 雇用; 付定金保留;
        books.retainAll(c);
        System.out.println("books和c取 交集后，book集合的元素为" + books);
        //清除c集合里的 所有元素
        c.clear();
        System.out.println("清除后c元素无"+ c);
    }
}