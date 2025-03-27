package w1_t3_organization;

public abstract class Component {

    protected String name;
    protected Integer salary;

    public Component(String name) {
        this.name = name;
    }

    public abstract void printSalary();

    public abstract String toXML(String indent);

    public String getXML(){
        return String.format("<%s name=\"%s\" salary=\"%d\" />\n", this.getClassName() , name, salary);
    }

    public String getClassName(){
        return this.getClass().getSimpleName();
    }

    public void rename(String newName){ name = newName; };

    public abstract Integer getSalary();

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract Component getChild(int index);

}
