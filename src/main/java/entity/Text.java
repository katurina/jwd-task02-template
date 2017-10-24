package entity;

public class Text implements Node {
	private String text;

	public Text() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		Text text1 = (Text) o;

		return getText() != null ? getText().equals(text1.getText()) : text1.getText() == null;
	}

	@Override
	public int hashCode() {
		return getText() != null ? getText().hashCode() : 0;
	}
}
