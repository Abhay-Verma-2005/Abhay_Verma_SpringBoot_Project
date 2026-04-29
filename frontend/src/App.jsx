import { useState, useEffect } from 'react'
const API = 'http://localhost:8080/students'
function App() {
  const [students, setStudents] = useState([])
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [course, setCourse] = useState('')
  const [editId, setEditId] = useState(null)
  const [message, setMessage] = useState('')

  useEffect(() => {
    fetchStudents()
  }, [])

  async function fetchStudents() {
    const res = await fetch(API)
    const data = await res.json()
    setStudents(data)
  }

  function clearForm() {
    setName('')
    setEmail('')
    setCourse('')
    setEditId(null)
  }

  function showMessage(msg) {
    setMessage(msg)
    setTimeout(() => setMessage(''), 3000)
  }

  async function handleSubmit(e) {
    e.preventDefault()
    const student = { name, email, course }

    if (editId) {
      await fetch(`${API}/${editId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(student)
      })
      showMessage('Student updated')
    } else {
      await fetch(API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(student)
      })
      showMessage('Student added')
    }

    clearForm()
    fetchStudents()
  }

  function handleEdit(s) {
    setName(s.name)
    setEmail(s.email)
    setCourse(s.course)
    setEditId(s.id)
  }

  async function handleDelete(id) {
    await fetch(`${API}/${id}`, { method: 'DELETE' })
    showMessage('Student deleted')
    fetchStudents()
  }

  return (
    <div className="app">
      <div className="header">
        <h1>Student Manager</h1>
        <p>Simple CRUD application</p>
      </div>

      {message && <div className="message">{message}</div>}

      <div className="form-card">
        <h2>{editId ? 'Edit Student' : 'Add Student'}</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-row">
            <input
              type="text"
              placeholder="Name"
              value={name}
              onChange={e => setName(e.target.value)}
              required
            />
            <input
              type="email"
              placeholder="Email"
              value={email}
              onChange={e => setEmail(e.target.value)}
              required
            />
            <input
              type="text"
              placeholder="Course"
              value={course}
              onChange={e => setCourse(e.target.value)}
              required
            />
          </div>
          <div className="form-actions">
            <button type="submit" className="btn btn-primary">
              {editId ? 'Update' : 'Add'}
            </button>
            {editId && (
              <button type="button" className="btn btn-cancel" onClick={clearForm}>
                Cancel
              </button>
            )}
          </div>
        </form>
      </div>

      <div className="table-card">
        <h2>All Students ({students.length})</h2>
        {students.length === 0 ? (
          <div className="empty-state">No students found</div>
        ) : (
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {students.map(s => (
                <tr key={s.id}>
                  <td>{s.id}</td>
                  <td>{s.name}</td>
                  <td>{s.email}</td>
                  <td>{s.course}</td>
                  <td>
                    <div className="actions">
                      <button className="btn-edit" onClick={() => handleEdit(s)}>Edit</button>
                      <button className="btn-delete" onClick={() => handleDelete(s.id)}>Delete</button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  )
}

export default App
