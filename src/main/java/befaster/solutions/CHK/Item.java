package befaster.solutions.CHK;

public enum Item {
    A(50, 'A'),
    B(30, 'B'),
    C(20, 'C'),
    D(15, 'D'),
    E(40, 'E');

    private Integer price;
    private char character;

    Item(Integer price, char character) {
        this.price = price;
        this.character = character;
    }

    public Integer getPrice() {
        return price;
    }

    public char getCharacter() {
        return character;
    }
}
