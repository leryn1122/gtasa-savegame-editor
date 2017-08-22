package nl.paulinternet.gtasaveedit.model;

public class VariableTitle implements TextFieldInterface
{
	private String text;
	private ReportableEvent onChange;
	private boolean hasChanged;
	
	public VariableTitle () {
		text = "";
		onChange = new ReportableEvent();
	}

	@Override
	public String getAllowedCharacters () {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012345789!\"$%&'[]+,-/.:;<=>?\\* ";
	}

	@Override
	public String getDefaultText () {
		return "";
	}

	@Override
	public int getMaximumLength () {
		return 99;
	}

	@Override
	public String getText () {
		return text;
	}
	
	@Override
	public void setText (String text) throws InvalidValueException {
		if (text == null) throw new InvalidValueException();
		if (!this.text.equals(text)) {
			this.text = text;
			onChange.report();
			hasChanged = true;
		}
	}

	@Override
	public Event onChange () {
		return onChange;
	}

	@Override
	public boolean isEnabled () {
		return true;
	}
	
	public boolean hasChanged () {
		return hasChanged;
	}
	
	public void resetChangedState () {
		hasChanged = false;
	}
}
