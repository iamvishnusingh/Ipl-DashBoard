package com.newton.ipldashboard.data;

import com.newton.ipldashboard.Model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;


public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log= LoggerFactory.getLogger(MatchDataProcessor.class);
    @Override
    public Match process(MatchInput matchInput) throws Exception {
      Match match= new Match();
      match.setId(Long.parseLong(matchInput.getId()));
      match.setCity(matchInput.getCity());
      match.setDate(LocalDate.parse(matchInput.getDate()));
      match.setPlayer_of_match(matchInput.getPlayer_of_match());
      match.setVenue(matchInput.getVenue());
      String firstinningsTeam,secondinningsTeam;
      if("bat".equals(matchInput.getToss_decision())){
          firstinningsTeam=matchInput.getToss_winner();
          secondinningsTeam=matchInput.getToss_winner().equals(matchInput.getTeam1())
                  ?matchInput.getTeam2():matchInput.getTeam1();

      }else{
          secondinningsTeam=matchInput.getToss_winner();
          firstinningsTeam =matchInput.getToss_winner().equals(matchInput.getTeam1())
                  ?matchInput.getTeam2():matchInput.getTeam1();
      }

      match.setTeam1(firstinningsTeam);
      match.setTeam2(secondinningsTeam);
      match.setToss_winner(matchInput.getToss_winner());
      match.setToss_decision(matchInput.getToss_decision());
      match.setWinner(matchInput.getWinner());
      match.setResult(matchInput.getResult());
      match.setResult_margin(matchInput.getResult_margin());
      match.setUmpire1(matchInput.getUmpire1());
      match.setUmpire2(matchInput.getUmpire2());


      return match;
    }
}
