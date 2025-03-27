package w1_t3_organization;

public class Main {
    public static void main(String[] args) {
        Department headOffice = new Department("Head Office");

        Department hr = new Department("HR Department");
        Department it = new Department("IT Department");

        Employee alice = new Employee("Alice", 50000);
        System.out.println("Created: " + alice.getXML());

        Employee bob = new Employee("Bob", 60000);
        System.out.println("Created: " + bob.getXML());

        Employee carol = new Employee("Carol", 55000);
        System.out.println("Created: " + carol.getXML());

        Employee dave = new Employee("Dave", 70000);
        System.out.println("Created: " + dave.getXML());

        hr.add(alice);
        hr.add(bob);

        it.add(carol);
        it.add(dave);

        headOffice.add(hr);
        headOffice.add(it);

        // Print total salary
        headOffice.printSalary();

        // Print XML structure
        System.out.println("\nOrganization Structure in XML:");
        System.out.println(headOffice.toXML(""));
    }
}

