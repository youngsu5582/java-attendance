//import crew.CrewNickname;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.List;
//
//public class CrewAttendanceRegisterFileReader {
//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//    /**
//     * 당장은 처음 헤더 정보가 필요없으므로 스킵한다.
//     */
//    private static final int SKIP_COUNT = 1;
//    private static final String NICKNAME_ATTENDANCE_SEPARATE_REGEX = ",";
//    private static final int NICKNAME_INDEX = 0;
//    private static final int ATTENDANCE_INDEX = 0;
//
//    private final String path;
//
//    public CrewAttendanceRegisterFileReader(final String path) {
//        this.path = path;
//    }
//
//    public CrewAttendanceRegister register() {
//        final List<String> lines = readLines();
//        final CrewAttendanceRegister register = new CrewAttendanceRegister(new HashMap<>());
//        lines.forEach(s -> {
//            final String[] ary = s.split(NICKNAME_ATTENDANCE_SEPARATE_REGEX);
//            final CrewNickname nickname = new CrewNickname(ary[NICKNAME_INDEX]);
//            final AttendanceTime attendanceTime = new AttendanceTime(LocalDateTime.parse(ary[ATTENDANCE_INDEX], DATE_TIME_FORMATTER));
//            register.add(nickname, attendanceTime);
//        });
//        return register;
//    }
//
//    private List<String> readLines() {
//        try {
//            return CsvFileReader.readLines(path, SKIP_COUNT);
//        } catch (final IOException e) {
//            throw new IllegalArgumentException("크루 출석 정보를 읽는 중 문제가 발생했습니다. 파일 명 : %s".formatted(path), e);
//        }
//    }
//}
