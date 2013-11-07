package edu.ycp.cs481.linkup.controller;

import edu.ycp.cs481.linkup.model.Rating;
import edu.ycp.cs481.linkup.persistence.Database;
import edu.ycp.cs481.linkup.persistence.PersistenceException;

public class RatingController {
		public void Rating(Rating inRating) throws PersistenceException{
			Database.getInstance().add_rating(inRating);
		}
	}


