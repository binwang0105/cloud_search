package easyrent.search.pojo;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Home {

	private String id;

	private String name;

	private String address;

	private long bed;

	private long bath;

	private long price;

	private String image;

	private String category_name;

	private String home_desc;

	private String pic1;

	private String pic2;

	private String pic3;

	private String pic4;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getBed() {
		return bed;
	}

	public void setBed(long bed) {
		this.bed = bed;
	}

	public long getBath() {
		return bath;
	}

	public void setBath(long bath) {
		this.bath = bath;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getHome_desc() {
		return home_desc;
	}

	public void setHome_desc(String home_desc) {
		this.home_desc = home_desc;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
}
