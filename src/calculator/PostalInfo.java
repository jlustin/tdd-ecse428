package calculator;

public class PostalInfo {
	
	String fromPostalCode, toPostalCode;
	String postalType;
	float maxLength, maxWidth, maxWeight, maxHeight,price, regularPrice,xpressPrice,priorityPrice;
	
	public PostalInfo(String fromPostalCode,String toPostalCode,String postalType,float maxLength,float maxWidth,float maxHeight, float maxWeight,float price){
		this.fromPostalCode = fromPostalCode;
		this.toPostalCode = toPostalCode;
		this.maxLength = maxLength;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.maxWeight = maxWeight;
		this.regularPrice = 0;
		this.xpressPrice = 0;
		this.priorityPrice = 0;
			
		if(postalType.equals("regular")){
			this.regularPrice = price;
		}
		else if (postalType.equals("xpress")){
			this.xpressPrice = price;
		}
		else if (postalType.equals("priority")){
			this.priorityPrice = price;
		}
					
	}

	public String getFromPostalCode() {
		return fromPostalCode;
	}

	public void setFromPostalCode(String fromPostalCode) {
		this.fromPostalCode = fromPostalCode;
	}

	public String getToPostalCode() {
		return toPostalCode;
	}

	public void setToPostalCode(String toPostalCode) {
		this.toPostalCode = toPostalCode;
	}

	public float getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(float maxLength) {
		this.maxLength = maxLength;
	}

	public float getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(float maxWidth) {
		this.maxWidth = maxWidth;
	}

	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public float getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(float maxHeight) {
		this.maxHeight = maxHeight;
	}

	public float getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(float regularPrice) {
		this.regularPrice = regularPrice;
	}

	public float getXpressPrice() {
		return xpressPrice;
	}

	public void setXpressPrice(float xpressPrice) {
		this.xpressPrice = xpressPrice;
	}

	public float getPriorityPrice() {
		return priorityPrice;
	}

	public void setPriorityPrice(float priorityPrice) {
		this.priorityPrice = priorityPrice;
	}
}
