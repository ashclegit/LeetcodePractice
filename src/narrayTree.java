import java.util.ArrayList;
import java.util.List;

public class narrayTree {


    private static class NavigationItem
    {
        String url;
        String label;
        List<NavigationItem> children;
        public NavigationItem(String url,String label)
        {
            this.url = url;
            this.label = label;
            this.children = new ArrayList<NavigationItem>();
        }
    }

    public void indent(int n){
        for(int i=0;i<n;i++)
            System.out.print("  ");
    }


    public void navigate(NavigationItem input){
        if(input==null) return;

        System.out.println(input.label + " " + input.url);
        for(NavigationItem a : input.children)
        {
            navigate(a);
            indent(input.children.size());
        }

        /*if(input.children.size() != 0)
        {
            int childsize = input.children.size();
            for(int i=0;i<childsize;i++)
            {
                navigate(input.children.get(i));
            }
        }*/

    }

    public static void main(String[] args) {

        narrayTree nat = new narrayTree();
        NavigationItem na  = new NavigationItem("www.google.com","google");
        NavigationItem nachild = new NavigationItem("www.twitter.com","twitter");
        NavigationItem nachild1 = new NavigationItem("www.linkedin.com","linkedin");
        NavigationItem nachild2 = new NavigationItem("www.facebook.com","facebook");
        NavigationItem nachild3 = new NavigationItem("www.ashwin.profile.com","myprofile");

        na.children.add(nachild);
        na.children.add(nachild1);
        na.children.add(nachild2);
        nachild1.children.add(nachild3);
        nat.navigate(na);
    }
}
