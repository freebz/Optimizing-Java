;; 락과 스핀락

locked:
	dd	0

spin_lock:
	mov	eax, 1
	xchg	eax, [locked]
	test	eax, eax
	jnz	spin_lock
	ret

spin_unlock:
	mov	eax, 0
	xchg	eax, [locked]
	ret
