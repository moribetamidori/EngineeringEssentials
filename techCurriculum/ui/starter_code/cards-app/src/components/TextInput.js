import React from 'react';

class TextInput extends React.Component {
  constructor(props) {
    super(props);
  }

  handleChange = (event) => {
    const value = event.target.value;
    this.props.onChange(value);
  }

  render() {
    return (
      <div className='form-group'>
        <label className='control-label'>{this.props.label}</label>
        <input type='text' className='form-control' name={this.props.name} value={this.props.value} onChange={this.handleChange} />
      </div>
    )
  }
}

export default TextInput;
