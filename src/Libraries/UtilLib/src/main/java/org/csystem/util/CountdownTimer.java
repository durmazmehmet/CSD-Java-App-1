package org.csystem.util;

import java.util.Timer;
import java.util.TimerTask;

public abstract class CountdownTimer {
    private long m_millisInFuture, m_countDownInterval;
    private Timer m_timer;
    private TimerTask m_timerTask;

    private void initTimer()
    {
        m_timerTask = new TimerTask() {
            private long m_remainingMs = m_millisInFuture;

            @Override
            public void run()
            {
                m_remainingMs -= m_countDownInterval;

                if (m_remainingMs <= 0) {
                    onFinish();
                    m_timer.cancel();
                }
                else
                    onTick(m_remainingMs);
            }
        };
    }

    public CountdownTimer(long millisInFuture, long countDownInterval)
    {
        m_millisInFuture = millisInFuture;
        m_countDownInterval = countDownInterval;
        m_timer = new Timer();
        this.initTimer();
    }

    public abstract void onTick(long millisUntilFinished);
    public abstract void onFinish();

    public final void start()
    {
        m_timer.scheduleAtFixedRate(m_timerTask, 0, m_countDownInterval);
    }
}