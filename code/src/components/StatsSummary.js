import React, { useEffect, useState } from "react";
import { Bar } from "react-chartjs-2";

const StatsSummary = () => {
  const [stats, setStats] = useState({});
  const [chartData, setChartData] = useState({});

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const response = await fetch("/api/stats", {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
          },
        });
        const data = await response.json();
        setStats(data);

        // Example chart data
        setChartData({
          labels: ["Wins", "Losses"],
          datasets: [
            {
              label: "Trade Outcomes",
              data: [data.wins, data.losses],
              backgroundColor: ["#4CAF50", "#F44336"],
            },
          ],
        });
      } catch (err) {
        console.error("Failed to fetch stats:", err);
      }
    };

    fetchStats();
  }, []);

  return (
    <div>
      <h2>Trading Dashboard</h2>
      <Bar data={chartData} />
      <p>Total Trades: {stats.totalTrades}</p>
      <p>Profit/Loss: {stats.profitLoss}</p>
    </div>
  );
};

export default StatsSummary;
