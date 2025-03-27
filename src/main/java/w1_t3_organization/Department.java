package w1_t3_organization;

import java.util.*;

public class Department extends Component{
    private List<Component> children = new ArrayList<>();

    public Department(String name) { super(name); }

    @Override
    public void printSalary(){
        System.out.printf("%s department total salary is: %d\n", this.name, getSalary());
    }

    @Override
    public String toXML(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s<Department name=\"%s\">\n", indent, name));
        for (Component child : children) {
            sb.append(child.toXML(indent + "  "));
        }
        sb.append(String.format("%s</Department>\n", indent));
        return sb.toString();
    }

    @Override
    public Integer getSalary() {
        int totalSalary = 0;
        for (Component child : this.children) {
            totalSalary += child.getSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return this.children.get(index);
    }
}
