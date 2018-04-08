package EnumStudy;

public enum  ColorTest implements Behavihour{
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    private String name;
    private int index;


    private ColorTest(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index+">>>>>>>>>>>"+this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }
}
