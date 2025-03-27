package w1_t3_organization;

public class Employee extends Component{
    public Employee(String name, Integer salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void printSalary() {
        System.out.println("Item: " + this.name);
    }

    @Override
    public Integer getSalary() { return this.salary; }

    @Override
    public String toXML(String indent) {
        return String.format("%s<Employee name=\"%s\" salary=\"%d\" />\n", indent, name, salary);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
}