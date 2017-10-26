package by.tc.task02.entity;

public class Text implements Node {
	private String text;

	public Text() {
	}

    public Text(String text) {
        this.text = text;
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

		Text that = (Text) o;

		return getText() != null ? getText().equals(that.getText()) : that.getText() == null;
	}

	@Override
	public int hashCode() {
		return getText() != null ? getText().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Text{" +
				"text='" + text + '\'' +
				'}';
	}
}
