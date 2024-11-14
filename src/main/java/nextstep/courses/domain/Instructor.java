package nextstep.courses.domain;

import nextstep.courses.exception.CannotApproveSessionException;

public class Instructor {
    private final InstructorId instructorId;
    private final long nsUserId;
    private final String loginId;

    public Instructor(final InstructorId instructorId) {
        this(instructorId, null, 0);
    }

    public Instructor(final InstructorId instructorId, final String loginId, final long nsUserId) {
        this.instructorId = instructorId;
        this.loginId = loginId;
        this.nsUserId = nsUserId;
    }

    public SessionOrder approveSessionOrder(SessionOrder sessionOrder) throws CannotApproveSessionException {
        if (!sessionOrder.isReadyOrderState()) {
            throw new CannotApproveSessionException("대기중인 신청상태만 승인 가능합니다.");
        }
        return sessionOrder.createApproveSessionOrder(this);
    }

    public SessionOrder cancelSessionOrder(SessionOrder sessionOrder) throws CannotApproveSessionException {
        if (!sessionOrder.isReadyOrderState()) {
            throw new CannotApproveSessionException("대기중인 신청상태만 승인 취소 가능합니다.");
        }
        return sessionOrder.createCancelSessionOrder(this);
    }

    public long getId() {
        return instructorId.getInstructorId();
    }
}
