// Создать перечисление, содержащее размеры одежды (XXS, XS, S, M, L). Перечисление содержит метод getDescription,
// возвращающий строку "Взрослый размер". Переопределить метод getDescription - для константы XXS метод должен возвращать строку
// “Детский размер”. Также перечисление должно содержать числовое значение euroSize(32, 34, 36, 38, 40),
// соответствующее каждому размеру. Создать конструктор, принимающий на вход euroSize.
//• Создать интерфейсы "Мужская Одежда" с методом "одетьМужчину" и "Женская Одежда" с методом "одетьЖенщину".
//• Создать абстрактный класс Одежда, содержащий переменные - размер одежды, стоимость, цвет.
//• Создать классы наследники Одежды - Футболка (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"),
// Штаны (реализует интерфейсы "Мужская Одежда" и "Женская Одежда"), Юбка (реализует интерфейсы "Женская Одежда"),
// Галстук (реализует интерфейсы "Мужская Одежда").
//• Создать массив, содержащий все типы одежды. Создать класс Ателье, содержащий методы одетьЖенщину, одетьМужчину,
// на вход которых будет поступать массив, содержащий все типы одежды.
// Метод одетьЖенщину выводит на консоль всю информацию о женской одежде. То же самое для метода одетьМужчину
enum Size {
    XXS(32), XS(34), S(36), M(38), L(40);
    int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public void getDescription() {
        if (this == XXS) {
            System.out.println("XXS детский размер ");
        } else {
            System.out.println("взрослый размер");
        }
    }
    public void getEuroSize(){
        System.out.println( " европейский размер " +euroSize);
    }
}
interface mencloth{
    void одетьМужчину();
}
interface womencloth{
    void одетьЖенщину();
}
abstract class cloth{
    public Size size;
    public double prise;
    public String color;
    public cloth(Size size, double prise, String color) {
        this.size = size;
        this.prise = prise;
        this.color = color;
    }
}
class Tshirt extends cloth implements mencloth, womencloth{ //футболка
    public Tshirt(Size size, double prise, String color) {
        super(size, prise, color);
    }

    @Override
    public void одетьМужчину() {
        System.out.println("Мужская футболка: размер - " + size + " цена - "  + prise +" цвет - " + color);
    }
    @Override
    public void одетьЖенщину() {
        System.out.println("Женская футболка: размер - " + size + " цена - "  + prise +" цвет - " + color);
    }
}
class Trousers extends cloth implements mencloth, womencloth{ //штаны
    public Trousers(Size size, double prise, String color) {
        super(size, prise, color);
    }

    @Override
    public void одетьМужчину(){
        System.out.println("Мужские штаны: размер - " + size + " цена - "  + prise +" цвет - " + color );
    }
    @Override
    public void одетьЖенщину() {
        System.out.println("Женские штаны: размер - " + size + " цена - "  + prise +" цвет - " + color);
    }
}
class Skirt extends cloth implements womencloth{ //штаны
    public Skirt(Size size, double prise, String color) {
        super(size, prise, color);
    }
    @Override
    public void одетьЖенщину(){
        System.out.println("юбка женская: размер - " + size + " цена - "  + prise +" цвет - " + color);
    }
}
class Tie extends cloth implements mencloth{ //галстук
    public Tie(Size size, double prise, String color) {
        super(size, prise, color);
    }
    @Override
    public void одетьМужчину(){
        System.out.println("галстук мужской: размер - " + size + " цена - "  + prise +" цвет - " + color);
    }
}
class Atelie {
    public void одетьЖенщину(cloth[] clothh) {
        for (cloth cl : clothh) {
            if (cl instanceof womencloth) {
                ((womencloth) cl).одетьЖенщину();
            }
        }
    }

    public void одетьМужчину(cloth[] clothh) {
        for (cloth cl : clothh) {
            if (cl instanceof mencloth) {
                ((mencloth) cl).одетьМужчину();
            }
        }
    }
}

    public class Main {
        public static void main(String[] args) {
            cloth[] clothh = new cloth[]{new Tshirt(Size.XS, 200, "черный"), new Trousers(Size.L, 500, "синий"), new Skirt(Size.XXS, 700, "фиолетовый"), new Tie(Size.M, 150, "зеленый")};
            Atelie at = new Atelie();
            at.одетьЖенщину(clothh);
            at.одетьМужчину(clothh);
            Size.XXS.getDescription();
            Size.XXS.getEuroSize();
        }
    }

