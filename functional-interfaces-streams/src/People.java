public record People(String name, String city, int age) {

    @Override
    public String toString() {
        return name;
    }
}
