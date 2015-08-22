package org.chinpon.helper;

import org.chinpon.model.entities.GameBoard;
import org.chinpon.model.entities.Hero;
import org.chinpon.model.entities.Room;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import alice.tuprolog.Theory;

/*
 * Keeper IA
 * 
 * room(id, contiguousRoom, heros, enemies)
 * room(1,[2,3,4], [1,2,3], [1,2])
 * 
 * state(room, value)
 * 
 * State
 * - GameBoard
 * - Monsters
 * - Hero 
 * - Clues
 * - Nº gain
 * 
 * Metric (Depend on the objectives)
 * 1- Moster attack a hero
 * 2- Nº monsters near a hero
 * 3- Nº monsters near other monsters
 * 3- Nº monsters near a clue ???
 * 
 * Objectives
 * - Kill everyone
 * 
 * Actions (Depend on the story)
 * - Gain threat 
 * - Attack
 * - Move
 * - 
 */

public class AdapterMasterMind {
	private GameBoard gameBoard; 
	
	public AdapterMasterMind(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	
	
	public void play() {
		Prolog engine = new Prolog();
		SolveInfo info;

		try {
			StringBuilder th = new StringBuilder();
			
			Struct term = null;
			for (Room room:gameBoard.getRooms().values()) {
				th.append("room").append("(");
				th.append(room.getId()).append(",");
				
				th.append("[");
				for (Room contiguous: room.getContiguous()) {
					th.append(contiguous.getId()).append(",");
				}
				if (room.getContiguous().size() > 0) {
					th.deleteCharAt(th.length() - 1);
				}
				th.append("]");
				
				th.append(",");
				th.append("[");
				for (Hero hero: room.getHeros()) {
					th.append(hero.getIdHero()).append(",");
				}
				if (room.getHeros().size() > 0) {
					th.deleteCharAt(th.length() - 1);
				}
				th.append("]");
				th.append("). \n");
			}
			
			th.append("states([]). \n");
			
			System.out.println(th.toString());			
			/*th.append("room(1,[2,3], [1,2,3], [1,2]). \n")
			.append("room(2,[1,4,5], [1,2,3], [1,2]). \n");*/
			
			
			
			
			
			//Term t = Term.createTerm("room(1,[2,3,4], [1,2,3], [1,2])");
			
			engine.setTheory(new Theory(th.toString()));
			info = engine.solve("room(1, [2, 3, 4], [1, 2, 3] ,X).");
			Term t = info.getVarValue("X");

			System.out.println(t);
		} catch (MalformedGoalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		/*} catch (NoSolutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		} catch (InvalidTheoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSolutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
