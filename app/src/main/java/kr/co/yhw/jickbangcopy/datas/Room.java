package kr.co.yhw.jickbangcopy.datas;

public class Room {

    private int price; // 만원단위로 기록 15000 => 1억 5천만원
    private String address; //구 와 동만 기록 (마포구 망원동)
    private int floor; // 층수 : 양수 , 0층 : 반지하, 음수 : 지하 ?층
    private String description ; // 설명문구

    public String getFormattedPrice() {
        if ( price < 10000 ){
            // 8,000만원 이런식으러 컴마만
            return String.format("%,d", this.price);
        }
        else {
            // 2억8,500 이런식으로 가공 =>28500 /10000
            return String.format("%d억%,d만원",(this.price/10000),(this.price%10000));
        }
    }

    public Room(int price, String address, int floor, String description) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
