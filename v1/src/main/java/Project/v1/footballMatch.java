package Project.v1;

public class footballMatch {
	
		String data;
		String teamA;
		String teamB;
		double winA;
		double draw;
		double winB;
		String league;
		
		public footballMatch(String data, String teamA, String teamB, double winA, double draw, double winB, String league) {
			this.data  = data;
			this.teamA = teamA;
			this.teamB = teamB;
			this.winA = winA;
			this.draw = draw;
			this.winB = winB;
			this.league = league;
		
		}

		public String returnMatch() {
			return (teamA + " - " + teamB + " " + data + " " + winA + " " + draw + " " + winB + " " + league);
		}
		
}
