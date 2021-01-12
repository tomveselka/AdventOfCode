package days;

public class PasswordRows {
		private int minimum;
		private int maximum;
		private String letter;
		private String password;
		public int getMinimum() {
			return minimum;
		}
		public void setMinimum(int minimum) {
			this.minimum = minimum;
		}
		public int getMaximum() {
			return maximum;
		}
		public void setMaximum(int maximum) {
			this.maximum = maximum;
		}
		public String getLetter() {
			return letter;
		}
		public void setLetter(String letter) {
			this.letter = letter;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public PasswordRows (int minimum, int maximum, String letter, String password) {
			this.minimum = minimum;
			this.maximum = maximum;
			this.letter = letter;
			this.password = password;
		}

}
