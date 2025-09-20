package telran;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameAppl {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean stopGame = false;
		int moves = 0;
		
		BullsAndCowsGame num = new BullsAndCowsGame();
		List<Integer> n = num.generate();
		
		List<Integer> numberUser = new ArrayList<Integer>();
		System.out.println(n);
		
		StringBuilder gameHistory = new StringBuilder();

		while (!stopGame) {
			
			bw.write("Enter four-digit number: ");
			bw.flush();
			String str = br.readLine();
			numberUser = str.chars()
			        .map(Character::getNumericValue)
			        .boxed()
			        .toList();
			

			Map<String, Integer> score = BullsAndCowsGame.checkNumbers(n, numberUser);
			moves++;
			
			gameHistory.append("Move ").append(moves)
            .append(" Enter's user: ").append(str)
            .append(" -> ").append(score)
            .append("\n");

			stopGame = BullsAndCowsGame.isGameFinish(score);
		}
		
		bw.write("You win in " + moves + " moves!");
		bw.flush();
		
		DateTimeFormatter dtfFile = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm");
        String fileName = LocalDateTime.now().format(dtfFile) + "_" + moves + ".log";

        File logFile = new File(fileName);

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(logFile))) {
            fileWriter.write(gameHistory.toString());
        }catch (EOFException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        
		bw.close();
		br.close();
	}

}
