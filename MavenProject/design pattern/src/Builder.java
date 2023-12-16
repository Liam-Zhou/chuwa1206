
class Job {
    private String name;
    private int salary;

    public String getName(){
        return this.name;
    }
    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

interface VirtualBuilder{
    VirtualBuilder setName(String name);
    VirtualBuilder setSalary(int salary);
    Job build();

}

class GreatJobBuilder implements VirtualBuilder{
    private String name;
    private int salary;
    public VirtualBuilder setName(String name){
        this.name=name+"---Great job";
        return this;
    }
    public VirtualBuilder setSalary(int salary){
        this.salary=salary;
        return this;
    }
    public Job build(){
        Job job=new Job();
        job.setName(name);
        job.setSalary(salary);
        return job;
    }
}

class RubbishJobBuilder implements VirtualBuilder{
    private String name;
    private int salary;
    public VirtualBuilder setName(String name){
        this.name=name+"---rubbish job";
        return this;
    }
    public VirtualBuilder setSalary(int salary){
        this.salary=salary;
        return this;
    }
    public Job build(){
        Job job=new Job();
        job.setName(name);
        job.setSalary(salary);
        return job;
    }
}

public class Builder {

}
