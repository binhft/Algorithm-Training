public class VersionControl {
	public boolean isBadVersion(int version) {
		if (version < 10) {
			return false;
		} 
		return true;
	}
}
