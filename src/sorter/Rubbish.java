package sorter;

public class Rubbish {
    private String name;
    private RubbishType rubbishType;

    public Rubbish(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public RubbishType getRubbishType() {
        return rubbishType;
    }

    public void setRubbishType(RubbishType rubbishType) {
        this.rubbishType = rubbishType;
    }


}
