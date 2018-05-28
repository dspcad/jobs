import java.util.LinkedList;

public class ch3_6{
    public static void main(String args[]){
        System.out.println("Test");

        animalQueue t = new animalQueue();
        t.enqueue(new Dog("hhwu"));
        t.enqueue(new Cat("anna"));
        t.enqueue(new Dog("aa1"));
        t.enqueue(new Dog("aa2"));
        t.enqueue(new Cat("bb1"));
        t.enqueue(new Dog("aa3"));
        t.enqueue(new Cat("bb2"));
        t.enqueue(new Dog("aa3"));
        t.enqueue(new Dog("aa4"));

        System.out.println("output: "+t.dequeueCat().name);
        System.out.println("output: "+t.dequeueAny().name);
    }
}

abstract class Animal{
    private int order;
    protected String name;
    public Animal(String n){this.name = n;}
    public void setOrder(int o){this.order = o;}
    public int getOrder(){ return this.order;}

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

class Dog extends Animal{
    public Dog(String n){super(n);}
}

class Cat extends Animal{
    public Cat(String n){super(n);}
}

class animalQueue{
    private LinkedList<Dog> l_dog;
    private LinkedList<Cat> l_cat;
    private int order;

    public animalQueue(){
        this.l_dog = new LinkedList<Dog>();
        this.l_cat = new LinkedList<Cat>();
        this.order = 0;
    }

    public void enqueue(Animal obj){
        obj.setOrder(this.order);
        this.order++;

        if(obj instanceof Dog)
            l_dog.add((Dog)obj);
        else if(obj instanceof Cat)
            l_cat.add((Cat)obj);
    }

    public Animal dequeueAny(){
        if(l_dog.size() == 0)
            return dequeueCat();
        else if(l_cat.size() == 0)
            return dequeueDog();

        Dog d = l_dog.peek();
        Cat c = l_cat.peek();

        if(d.getOrder() < c.getOrder())
            return dequeueDog();
        else
            return dequeueCat();
    }   

    public Dog dequeueDog(){
        return l_dog.poll();
    }

    public Cat dequeueCat(){
        return l_cat.poll();
    }

}
