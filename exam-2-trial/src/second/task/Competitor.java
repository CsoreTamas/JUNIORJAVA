package second.task;

import java.util.Objects;

public class Competitor {
    private String name;
    private int appleCount;

    public Competitor() {
    }

    public Competitor(String name, int appleCount) {
        this.name = name;
        this.appleCount = appleCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppleCount() {
        return appleCount;
    }

    public void setAppleCount(int appleCount) {
        this.appleCount = appleCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Competitor that = (Competitor) o;
        return appleCount == that.appleCount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, appleCount);
    }

    @Override
    public String toString() {
        return "secondtask.SecondTask{" +
               "name='" + name + '\'' +
               ", appleCount=" + appleCount +
               '}';
    }
}
