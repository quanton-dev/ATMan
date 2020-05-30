export default {
  authenticate(detail) {
    return new Promise((resolve, reject) => {
      ;(detail.username === 'ysf' || detail.username === 'ysf@example.com') &&
      detail.password === 'YsFxX!'
        ? resolve({ result: 'success' })
        : reject(new Error('Invalid credentials'))
    })
  }
}
