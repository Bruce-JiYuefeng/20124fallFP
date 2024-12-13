package services;

import dao.TradeDao;
import model.Trade;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;

public class TradeService {
    private static final Logger LOGGER = Logger.getLogger(TradeService.class.getName());
    private final TradeDao tradeDao = new TradeDao();

    public boolean saveTrades(List<Trade> trades) {
        try {
            return tradeDao.saveTrades(trades);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving trades", e);
            return false;
        }
    }

    public List<Trade> getTradesByUserId(Long userId) {
        try {
            return tradeDao.getTradesByUserId(userId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving trades for user: " + userId, e);
            return null;
        }
    }

    public boolean deleteTradeById(long tradeId) {
        try {
            return tradeDao.deleteTrade(tradeId);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting trade with ID: " + tradeId, e);
            return false;
        }
    }
} 