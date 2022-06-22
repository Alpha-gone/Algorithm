package search;

public abstract class Search {
    protected String name;
    protected StringBuilder stringBuilder;

    public abstract void search(int index);

    public String getName(){
        return name;
    }

    public void showResult(){
        System.out.println(stringBuilder);
    }

}
