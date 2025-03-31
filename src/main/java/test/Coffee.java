package test;

interface Coffee {
    String getDescription();
}

// This is the simplest kind of coffee - "plain" coffee
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Plain coffee";
    }
}

// Decorator that adds milk to coffee
class MilkDecorator implements Coffee {
    private Coffee base; // This holds the coffee we're decorating

    public MilkDecorator(Coffee base) {
        this.base = base; // Wrap the base coffee
    }

    public String getDescription() {
        // Add "with milk" to whatever the base coffee says
        return base.getDescription() + " with milk";
    }
}

// Decorator that adds sugar to coffee
class SugarDecorator implements Coffee {
    private Coffee base;

    public SugarDecorator(Coffee base) {
        this.base = base;
    }

    public String getDescription() {
        // Add "with sugar" to whatever the base coffee says
        return base.getDescription() + " with sugar";
    }
}



