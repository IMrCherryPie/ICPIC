package com.dstu.domain;

import com.dstu.dao.PartyDAO;
import com.dstu.entity.Party;

import java.util.ArrayList;

public class Domain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        PartyDAO partyDAO = new PartyDAO();

        ArrayList<Party> party = (ArrayList<Party>) partyDAO.findAll();

        System.out.println(party);

    }
}
