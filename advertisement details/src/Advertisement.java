public class Advertisement {
	Integer id;
	String advertisementMedia;
	Double amountSpent;
	Integer noOfAudienceAttracted;
	public Advertisement() {
		super();
	}
	public Advertisement(String advertisementMedia, Double amountSpent, Integer noOfAudienceAttracted) {
		super();
		this.advertisementMedia = advertisementMedia;
		this.amountSpent = amountSpent;
		this.noOfAudienceAttracted = noOfAudienceAttracted;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdvertisementMedia() {
		return advertisementMedia;
	}
	public void setAdvertisementMedia(String advertisementMedia) {
		this.advertisementMedia = advertisementMedia;
	}
	public Double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(Double amountSpent) {
		this.amountSpent = amountSpent;
	}
	public Integer getNoOfAudienceAttracted() {
		return noOfAudienceAttracted;
	}
	public void setNoOfAudienceAttracted(Integer noOfAudienceAttracted) {
		this.noOfAudienceAttracted = noOfAudienceAttracted;
	}
}
