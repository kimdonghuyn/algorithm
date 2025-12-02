import java.util.*;

// [PCCP 기출문제] 1번 / 동영상 재생기

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenInSeconds = toSeconds(video_len);
        int posInSeconds = toSeconds(pos);
        int opStartInSeconds = toSeconds(op_start);
        int opEndInSeconds = toSeconds(op_end);

        if (checkIsOpening(opStartInSeconds, opEndInSeconds, posInSeconds)) {
            posInSeconds = opEndInSeconds;
        }

        for (int i = 0; i < commands.length; i++) {
            switch(commands[i]){
                case "next":
                    posInSeconds = Math.min(posInSeconds + 10, videoLenInSeconds);
                    break;
                case "prev":
                    posInSeconds = Math.max(posInSeconds - 10, 0);
                default:
                    break;
            }

            if (checkIsOpening(opStartInSeconds, opEndInSeconds, posInSeconds)) {
                posInSeconds = opEndInSeconds;
            }

        }

        return toMinuteSecondString(posInSeconds);
    }


    private static int toSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        return minutes*60 + seconds;
    }

    private static String toMinuteSecondString(int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        return String.format("%02d:%02d", mm, ss);
    }

    private static boolean checkIsOpening(int opStartInSeconds, int opEndInSeconds, int posInSeconds) {
        return opStartInSeconds <= posInSeconds && posInSeconds <= opEndInSeconds;
    }
}