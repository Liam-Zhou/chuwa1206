interface AbstractProduct {
    void produce();
}

class ProductA implements AbstractProduct {
    public void produce(){
        System.out.println("Produce product A");
    }
}

class ProductB implements AbstractProduct {
    public void produce(){
        System.out.println("Produce product B");
    }
}

interface AbstractFactory {
    AbstractProduct produceProduct();
}

class FactoryA implements AbstractFactory {
    public AbstractProduct produceProduct(){
        return new ProductA();
    }
}

class FactoryB implements AbstractFactory {
    public AbstractProduct produceProduct(){
        return new ProductB();
    }
}

