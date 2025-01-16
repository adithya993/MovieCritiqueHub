import React from 'react'

const NotFound = () => {
    let params = useParams();
    const key = params.ytTrailerId;
    return (
        <div>
            This Page could not be found
        </div>
    )
}

export default NotFound; 