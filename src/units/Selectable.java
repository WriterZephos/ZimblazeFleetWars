package units;

public interface Selectable extends Unit{  //this interface is for anything that can be selected.
	
	public abstract void select();
	
	public abstract void deselect();
	
	public abstract boolean getSelected();

}
